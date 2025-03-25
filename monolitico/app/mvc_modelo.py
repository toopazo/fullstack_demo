from app.perfiles import (
    AdministradorSistema,
    GerenteSucursal,
    EmpleadoVentas,
    Logística,
)


class Modelo:
    def __init__(self):
        """
        Conectarse a la BD
        """
        self.perfiles = [
            AdministradorSistema(),
            GerenteSucursal(),
            EmpleadoVentas(),
            Logística(),
        ]

    def main(self):
        """
        Realizar validación de los datos escritos a la BD y de la lectura de los datos
        """
        print("Validando datos escritos a la BD y traspasando los datos solicitados")
