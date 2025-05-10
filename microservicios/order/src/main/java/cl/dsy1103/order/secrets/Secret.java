package cl.dsy1103.order.secrets;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Secret implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String host;
    private Integer port;
    private String dbname;
}