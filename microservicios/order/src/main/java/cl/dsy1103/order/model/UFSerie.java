package cl.dsy1103.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// {
//     "fecha": "2025-05-13T04:00:00.000Z",
//     "valor": 39144.01
// }

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFSerie {
    private String fecha;
    private double valor;
}
