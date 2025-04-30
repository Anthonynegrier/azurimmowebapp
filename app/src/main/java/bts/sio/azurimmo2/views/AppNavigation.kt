package bts.sio.azurimmo2.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import bts.sio.azurimmo.views.batiment.AppartementList
import bts.sio.azurimmo2.views.appartement.AppartementAdd
import bts.sio.azurimmo.views.batiment.BatimentList
import bts.sio.azurimmo.views.contrat.ContratList
import bts.sio.azurimmo.views.locataire.LocataireList
import bts.sio.azurimmo.views.paiement.PaiementList
import bts.sio.azurimmo.views.réparation.ReparationList
import bts.sio.azurimmo.viewsmodel.appartement.AppartementViewModel
import bts.sio.azurimmo.viewsmodel.batiment.BatimentViewModel
import bts.sio.azurimmo2.views.batiment.BatimentAdd


@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "batiments_list",
        modifier = modifier
    ) {
        composable("batiments_list") {
            val viewModel: BatimentViewModel = viewModel()
            BatimentList(viewModel = viewModel, navController = navController)
        }
        composable("appartements_list") {
            val viewModel: AppartementViewModel = viewModel()
            AppartementList(viewModel = viewModel, navController = navController)
        }
        composable("contrats_list") {
            ContratList()
        }
        composable("locataires_list") {
            LocataireList()
        }
        composable("paiements_list") {
            PaiementList()
        }
        composable("reparations_list") {
            ReparationList()
        }
        composable("add_batiment") {
            BatimentAdd(navController = navController)
        }
        composable(
            "add_appartement/{batimentId}",
            arguments = listOf(navArgument("batimentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val batimentId = backStackEntry.arguments?.getInt("batimentId") ?: -1
            if (batimentId != -1) {
                AppartementAdd(batimentId = batimentId, navController = navController)
            } else {
                Text("Erreur : Identifiant de bâtiment manquant")
            }
        }

    }
}