/**CHeaderFile*****************************************************************

  FileName    [required]

  PackageName [required]

  Synopsis [High level functionalities for Incrememntal SBMC]

  Description [User-commands directly use function defined in this module. 
  This is the highest level in the Incrememntal SBMC API architecture.]

  SeeAlso  []

  Author   [Tommi Junttila, Marco Roveri]

  Copyright [ This file is part of the ``bmc.sbmc'' package of NuSMV version 2.
  Copyright (C) 2006 Tommi Junttila.

  NuSMV version 2 is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public License
  as published by the Free Software Foundation; either version 2 of
  the License, or (at your option) any later version.

  NuSMV version 2 is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General Public
  License along with this library; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
  USA.

  For more information of NuSMV see <http://nusmv.irst.itc.it> or
  email to <nusmv-users@irst.itc.it>.  Please report bugs to
  <nusmv-users@irst.itc.it>.

  To contact the NuSMV development board, email to  <nusmv@irst.itc.it>. ]

  Revision    [$Id: sbmcBmcInc.h,v 1.1.2.3 2006/06/29 13:36:49 nusmv Exp $]

******************************************************************************/

#ifndef _SBMC_BMCINC
#define _SBMC_BMCINC

#include "utils/utils.h"
#include "prop/prop.h"

/*---------------------------------------------------------------------------*/
/* Constant declarations                                                     */
/*---------------------------------------------------------------------------*/


/*---------------------------------------------------------------------------*/
/* Type declarations                                                         */
/*---------------------------------------------------------------------------*/


/*---------------------------------------------------------------------------*/
/* Structure declarations                                                    */
/*---------------------------------------------------------------------------*/


/*---------------------------------------------------------------------------*/
/* Variable declarations                                                     */
/*---------------------------------------------------------------------------*/


/*---------------------------------------------------------------------------*/
/* Macro declarations                                                        */
/*---------------------------------------------------------------------------*/


/**AutomaticStart*************************************************************/

/*---------------------------------------------------------------------------*/
/* Function prototypes                                                       */
/*---------------------------------------------------------------------------*/

EXTERN int Sbmc_zigzag_incr ARGS((Prop_ptr ltlprop,
                                  const int max_k,
                                  const int opt_do_virtual_unrolling,
                                  const int opt_do_completeness_check));

/**AutomaticEnd***************************************************************/

#endif /* _SBMC_BMCINC */
