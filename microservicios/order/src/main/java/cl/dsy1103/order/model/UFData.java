package cl.dsy1103.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// {
//     "version": "1.7.0",
//     "autor": "mindicador.cl",
//     "codigo": "uf",
//     "nombre": "Unidad de fomento (UF)",
//     "unidad_medida": "Pesos",
//     "serie": [
//         {
//             "fecha": "2025-05-13T04:00:00.000Z",
//             "valor": 39144.01
//         }
//     ]
// }

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFData {
    private String version;
    private String autor;
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private UFSerie[] serie;

}
