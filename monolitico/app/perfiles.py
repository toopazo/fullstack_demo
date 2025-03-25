# Perfiles del sistema


class AdministradorSistema:
    def __init__(self):

        self.permisos = [
            # Usuarios
            "crear_usuario",  # C
            "leer_usuario",  # R
            "modificar_usuario",  # U
            "eliminar_usuario",  # D
            # Permisos usuario
            "modificar_permiso_usuario",  # U
        ]
        self.notificaciones = ["estado_sistema", "rendimiento_sistema"]


class GerenteSucursal:
    def __init__(self):
        self.permisos = [
            # Stock
            "crear_stock",  # C
            "leer_stock",  # R
            "modificar_stock",  # U
            "eliminar_stock",  # D
            # Pedidos
            "crear_pedido",  # C
            "leer_pedido",  # R
            "modificar_pedido",  # U
            "eliminar_pedido",  # D
        ]
        self.notificaciones = ["reporte_ventas", "inventario", "rendimiento_sucursal"]


class EmpleadoVentas:
    def __init__(self):
        self.permisos = [
            # Boleta
            "crear_boleta",  # C
            "leer_boleta",  # R
            "modificar_boleta",  # U
            "eliminar_boleta",  # D
            # Factura
            "crear_factura",  # C
            "leer_factura",  # R
            "modificar_factura",  # U
            "eliminar_factura",  # D
            # Stock
            # "crear_stock",  # C
            "leer_stock",  # R
            # "modificar_stock",  # U
            # "eliminar_stock",  # D
        ]
        self.notificaciones = ["reporte_boletas", "reporte_facturas"]


class Logística:
    def __init__(self):
        self.permisos = [
            # Envío
            "crear_envio",  # C
            "leer_envio",  # R
            "modificar_envio",  # U
            "eliminar_envio",  # D
            # Pedido
            "crear_pedido",  # C
            "leer_pedido",  # R
            "modificar_pedido",  # U
            "eliminar_pedido",  # D
        ]
