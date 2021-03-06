/* This software was developed by employees of the National Institute of
 * Standards and Technology (NIST), an agency of the Federal Government.
 * Pursuant to title 15 United States Code Section 105, works of NIST
 * employees are not subject to copyright protection in the United States
 * and are considered to be in the public domain.  As a result, a formal
 * license is not needed to use the software.
 *
 * This software is provided by NIST as a service and is expressly
 * provided "AS IS".  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
 * AND DATA ACCURACY.  NIST does not warrant or make any representations
 * regarding the use of the software or the results thereof including, but
 * not limited to, the correctness, accuracy, reliability or usefulness of
 * the software.
 *
 * Permission to use this software is contingent upon your acceptance
 * of the terms of this agreement.
 */
package gov.nist.csd.acpt.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import gov.nist.csd.acpt.ACPTFrame;
import gov.nist.csd.acpt.target.TargetInfo;
import gov.nist.csd.acpt.target.TargetTreeUtil;
import gov.nist.csd.acpt.util.Generalproperties;
import gov.nist.csd.acpt.util.GraphicsUtil;

/**
 * This class implements the (XACML) target editor panel.
 *
 * @author steveq@nist.gov
 * @version $Revision$, $Date$
 * @since 1.6
 */

public class MULTILEVELSubjectLevelsPanel extends JPanel
{

    /***************************************************************************
     * Constants
     **************************************************************************/

    private static final long                       serialVersionUID       = 0;

    /***************************************************************************
     * Variables
     **************************************************************************/

    // public JButton updateValueButton = null;
    public JButton                                  addAttributeButton     = null;
    // public JTextField valueField = null;
    public JComboBox                                subjectComboBox        = null;
    public JComboBox                                levelComboBox          = null;
    // public JComboBox resourceComboBox = null;
    // public JComboBox actionComboBox = null;
    // public JComboBox decisionComboBox = null;
    // public JList list = null;
    // public DefaultListModel listmodel = null;

    private ACPTFrame                               frame                  = null;
    private JTree                                   modelTree              = null;
    private JTree                                   targetTree             = null;
    private ModelInfo                               modelInfo              = null;
    private boolean                                 editable               = false;
    private TitledBorder                            titledBorder           = null;

    /* Adapters */
    public MultiLevelSubjectLevelPanelActionAdapter userPanelActionAdapter = null;

    /***************************************************************************
     * Constructors
     **************************************************************************/

    public MULTILEVELSubjectLevelsPanel(ACPTFrame frame, JTree modelTree, ModelInfo modelInfo, boolean editable)
    {

        this.frame = frame;
        this.modelTree = modelTree;
        this.targetTree = frame.targetPanel.getTargetTree();
        this.modelInfo = modelInfo;
        setAdapters();
        setPanels(modelInfo);
        setEditable(editable);
    }

    /***************************************************************************
     * Initialization methods
     **************************************************************************/

    private void setAdapters()
    {

        this.userPanelActionAdapter = new MultiLevelSubjectLevelPanelActionAdapter(this);

    }

    private void setPanels(ModelInfo modelInfo)
    {

        /******************** Name panel *************************/
        /*
         * JLabel valueLabel = new JLabel("Name: ", JLabel.LEFT);
         * valueLabel.setPreferredSize( new Dimension(75,
         * GraphicsUtil.FIELD_HEIGHT)); valueLabel.setMaximumSize( new
         * Dimension(75, GraphicsUtil.FIELD_HEIGHT));
         *
         * this.valueField = new JTextField(modelInfo.getValue());
         * this.valueField.setPreferredSize( new Dimension(150,
         * GraphicsUtil.FIELD_HEIGHT)); this.valueField.setMaximumSize( new
         * Dimension(150, GraphicsUtil.FIELD_HEIGHT));
         *
         * this.updateValueButton = new JButton("Update");
         * this.updateValueButton.setPreferredSize( new Dimension(80,
         * GraphicsUtil.FIELD_HEIGHT)); this.updateValueButton.setMaximumSize(
         * new Dimension(80, GraphicsUtil.FIELD_HEIGHT));
         *
         * this.updateValueButton.addActionListener(userPanelActionAdapter);
         * this.updateValueButton.setActionCommand("Update");
         *
         * JPanel namePanel = new JPanel(); titledBorder =
         * BorderFactory.createTitledBorder("Name");
         * namePanel.setBorder(titledBorder);
         *
         * namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
         *
         * namePanel.add(Box.createRigidArea(new
         * Dimension(15,GraphicsUtil.FIELD_HEIGHT)));
         *
         * namePanel.add(valueLabel); namePanel.add(Box.createRigidArea(new
         * Dimension(15,GraphicsUtil.FIELD_HEIGHT)));
         *
         * namePanel.add(valueField); namePanel.add(Box.createRigidArea(new
         * Dimension(15,GraphicsUtil.FIELD_HEIGHT)));
         *
         * namePanel.add(updateValueButton);
         * namePanel.add(Box.createRigidArea(new
         * Dimension(15,GraphicsUtil.FIELD_HEIGHT)));
         */
        /********************
         * Object (e.g., button, combobox) Creation
         *************************/

        JLabel addRuleAdditionLabel = new JLabel("New Rule Addition: ", SwingConstants.LEFT);
        addRuleAdditionLabel.setPreferredSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));
        addRuleAdditionLabel.setMaximumSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));

        // String[] testStrings = { "Attr 1", "Attr 2", "Attr 3", "Attr 4" };

        DefaultMutableTreeNode rootNode = TargetTreeUtil.getRootNode(targetTree);
        String[] testStrings =
                TargetTreeUtil.getTargetTreeChildrenValues2StrArr(rootNode, TargetInfo.SUBJECT_ATTRIBUTES, 2);

        JLabel addSubjectLabel = new JLabel("Subject: ", SwingConstants.LEFT);
        addSubjectLabel.setPreferredSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));
        addSubjectLabel.setMaximumSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));

        JLabel addLevelLabel = new JLabel("Level: ", SwingConstants.LEFT);
        addLevelLabel.setPreferredSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));
        addLevelLabel.setMaximumSize(new Dimension(75, GraphicsUtil.FIELD_HEIGHT));

        subjectComboBox = new JComboBox(
                TargetTreeUtil.getTargetTreeChildrenValues2StrArr(rootNode, TargetInfo.SUBJECT_ATTRIBUTES, 2));
        // subjectComboBox.setSelectedIndex(0);
        subjectComboBox.setActionCommand("SubjectComboBox");
        subjectComboBox.addActionListener(userPanelActionAdapter);
        subjectComboBox.setPreferredSize(new Dimension(150, GraphicsUtil.FIELD_HEIGHT));
        subjectComboBox.setMaximumSize(new Dimension(150, GraphicsUtil.FIELD_HEIGHT));

        levelComboBox = new JComboBox(Generalproperties.MultiLevelStateNumberArray);
        // levelComboBox.setSelectedIndex(0);
        levelComboBox.setActionCommand("LevelComboBox");
        levelComboBox.addActionListener(userPanelActionAdapter);
        levelComboBox.setPreferredSize(new Dimension(150, GraphicsUtil.FIELD_HEIGHT));
        levelComboBox.setMaximumSize(new Dimension(150, GraphicsUtil.FIELD_HEIGHT));

        addAttributeButton = new JButton("Update");
        addAttributeButton.setPreferredSize(new Dimension(80, GraphicsUtil.FIELD_HEIGHT));
        addAttributeButton.setMaximumSize(new Dimension(80, GraphicsUtil.FIELD_HEIGHT));

        addAttributeButton.addActionListener(userPanelActionAdapter);
        addAttributeButton.setActionCommand("Update Rule");

        /******************** Combobox value Setup *************************/

        String values[] = modelInfo.getValue().split("#");
        for (int i = 0; i < values.length; i++)
        {
            if (i == 0)
            {
                subjectComboBox.setSelectedItem(values[i]);
            }
            else if (i == 1)
            {
                levelComboBox.setSelectedItem(values[i]);
            }
        }

        /******************** Add Rule Addition panel *************************/

        JPanel addRulePanel = new JPanel();
        addRulePanel.setLayout(new BoxLayout(addRulePanel, BoxLayout.Y_AXIS));

        JPanel addRuleEastPanel = new JPanel();
        addRuleEastPanel.setLayout(new BoxLayout(addRuleEastPanel, BoxLayout.Y_AXIS));
        addRuleEastPanel.add(addSubjectLabel);
        addRuleEastPanel.add(Box.createRigidArea(new Dimension(15, GraphicsUtil.DEFAULT_GAP)));
        addRuleEastPanel.add(addLevelLabel);
        addRuleEastPanel.add(Box.createRigidArea(new Dimension(15, GraphicsUtil.DEFAULT_GAP)));

        JPanel addRuleCenterPanel = new JPanel();
        addRuleCenterPanel.setLayout(new BoxLayout(addRuleCenterPanel, BoxLayout.Y_AXIS));
        addRuleCenterPanel.add(subjectComboBox);
        addRuleCenterPanel.add(Box.createRigidArea(new Dimension(15, GraphicsUtil.DEFAULT_GAP)));
        addRuleCenterPanel.add(levelComboBox);

        JPanel addRuleCWestPanel = new JPanel();

        addRuleCWestPanel.setLayout(new BoxLayout(addRuleCWestPanel, BoxLayout.Y_AXIS));
        addRuleCWestPanel.add(Box.createRigidArea(new Dimension(15, 15)));
        addRuleCWestPanel.add(addAttributeButton);

        TitledBorder titledBorder3 = BorderFactory.createTitledBorder("Level Update");
        addRulePanel.setBorder(titledBorder3);
        addRulePanel.setLayout(new BorderLayout());
        addRulePanel.add(addRuleEastPanel, BorderLayout.WEST);
        addRulePanel.add(addRuleCenterPanel, BorderLayout.CENTER);
        addRulePanel.add(addRuleCWestPanel, BorderLayout.EAST);

        // this.setLayout(new BorderLayout());
        // this.add(addRulePanel, BorderLayout.CENTER);

        /* Titled border for this panel. */
        titledBorder = BorderFactory.createTitledBorder(modelInfo.getValue() + " properties");
        this.setBorder(titledBorder);

    }

    /***************************************************************************
     * Public methods
     **************************************************************************/

    public void setEditable(boolean editable)
    {

        this.editable = editable;
        // this.valueField.setEnabled(editable);
        // this.updateValueButton.setEnabled(editable);

    }

    public void updateTargetValue(String value)
    {

        this.modelInfo.setValue(value);
        if (modelInfo.getModelType().equals(TargetInfo.ROOT))
        {
            this.frame.setProjectName(value);
        }
        titledBorder.setTitle(value + " properties");
        this.repaint();
        this.modelTree.repaint();
        return;
    }

    public String getRuleValue()
    {

        if ((subjectComboBox.getSelectedItem() == null) || (levelComboBox.getSelectedItem() == null))
        {

            // Warning
            GraphicsUtil.showWarningDialog("cannot add a new level due to null.", "Null Warning", null);
            return null;
        }

        String subj = (String) subjectComboBox.getSelectedItem();
        String level = (String) levelComboBox.getSelectedItem();

        String value = subj + "#" + level;

        return value;
    }

    /***************************************************************************
     * Inner classes
     **************************************************************************/

    /**
     * This inner class implements the target panel mouse adapter.
     *
     * @author steveq@nist.gov
     * @version $Revision$, $Date$
     * @since 1.6
     */
    class MultiLevelSubjectLevelPanelActionAdapter implements ActionListener
    {

        MULTILEVELSubjectLevelsPanel userPanel = null;

        MultiLevelSubjectLevelPanelActionAdapter(MULTILEVELSubjectLevelsPanel userPanel)
        {

            this.userPanel = userPanel;

        }

        @Override
        public void actionPerformed(ActionEvent e)
        {

            System.out.println("Group Panel: " + e.getActionCommand());

            if (e.getActionCommand().equals("Update"))
            {

                // String value = valueField.getText();
                // updateTargetValue(value);

            }
            else if (e.getActionCommand().equals("Update Rule"))
            {

                System.out.println("Got update rule button");
                String value = getRuleValue();
                if (value != null)
                {
                    updateTargetValue(value);
                }

            }

            else
            {

                // System.err.println("GroupPanel warning: command not
                // implemented: " +
                // e.getActionCommand());
            }

        }

    }

}
