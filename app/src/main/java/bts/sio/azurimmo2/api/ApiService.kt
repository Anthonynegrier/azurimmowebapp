package bts.sio.azurimmo2.api

import bts.sio.azurimmo2.model.*
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface ApiService {
    @GET("batiments")
    suspend fun getBatiments(): List<Batiment>

    @GET("appartements")
    suspend fun getAppartements(): List<Appartement>

    @GET("contrats")
    suspend fun getContrats(): List<Contrat>

    @GET("locataires")
    suspend fun getLocataires(): List<Locataire>

    @GET("paiements")
    suspend fun getPaiements(): List<Paiement>

    @GET("reparations")
    suspend fun getReparations(): List<Reparation>

    @POST("batiments/")
    suspend fun addBatiments(@Body batiment: Batiment): retrofit2.Response<Batiment>

    @POST("appartements/")
    suspend fun addAppartements(@Body appartement: Appartement): retrofit2.Response<Appartement>
}