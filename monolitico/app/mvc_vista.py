import time
import datetime
from app.mvc_controlador import Controlador


class Vista:
    def __init__(self):
        """
        Levantar la pag web
        """
        self.controlador = Controlador()

    def main(self):
        """
        Gestionar trafico de la pag web y comunicarse con la lógica del negocio
        """

        while True:
            time.sleep(5)
            print(
                f"Gestionando tráfico de la pag web y comunicándose con la lógica del negocio {datetime.datetime.now().isoformat()}"
            )
            self.controlador.main()
