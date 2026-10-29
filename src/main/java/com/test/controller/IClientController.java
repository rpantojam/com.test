package com.test.controller;

import com.test.model.Client;
import com.test.model.dtos.ClientDto;
import com.test.model.dtos.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Clientes", description = "Endpoints para la gestión del catálogo de clientes")
public interface IClientController {

    @Operation(
            summary = "Obtener todos los clientes",
            description = "Busca los clientes registrados en la base de datos."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Clientes encontrados con éxito",
                    content = @Content(schema = @Schema(implementation = ClientDto.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Vacío si no encuentra nada.",
                    content = @Content
            )
    })
    ResponseEntity<List<ClientDto>> getClients();

    @Operation(
            summary = "Crear cliente",
            description = "Crea un nuevo cliente a partir de la información que contiene el body."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente creado con éxito",
                    content = @Content(schema = @Schema(implementation = Client.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Vacío si no lo logra crear.",
                    content = @Content
            )
    })
    ResponseEntity<ServiceResponse> saveClient(ClientDto client);

    @Operation(
            summary = "Eliminar cliente",
            description = "Elimina un cliente a partir de su identificador único."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Cliente eliminado con éxito",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cliente no encontrado.",
                    content = @Content
            )
    })
    ResponseEntity<ServiceResponse> deleteClient(Long clientId);

}
