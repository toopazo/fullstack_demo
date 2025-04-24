#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import os
import sys
from sqlalchemy import create_engine
import cx_Oracle


def main():
    """Run administrative tasks."""
    os.environ.setdefault("DJANGO_SETTINGS_MODULE", "transbank.settings")
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


def test_alchemy():

    user = "ADMIN"
    password = "l,dsa*&^dsa45dsa4545ASD"
    tns = "(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.sa-santiago-1.oraclecloud.com))(connect_data=(service_name=gcd54379833fdb0_cbicn24vcdndg5uc_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))"

    engine = create_engine("oracle+cx_oracle://{0}:{1}@{2}".format(user, password, tns))
    con = engine.connect()
    result = con.execute("SELECT * FROM menu")
    print(result.fetchall())


def test2():
    cx_Oracle.init_oracle_client(
        config_dir="/opt/oracle/instantclient_23/instantclient_23_7"
        # config_dir="/home/toopazo/Downloads/Wallet_CBICN24VCDNDG5UC"
    )

    DIALECT = "oracle"
    SQL_DRIVER = "cx_oracle"
    USERNAME = "ADMIN"  # enter your username
    PASSWORD = "l,dsa*&^dsa45dsa4545ASD"  # enter your password
    HOST = "adb.sa-santiago-1.oraclecloud.com"  # enter the oracle db host url
    PORT = 1522  # enter the oracle port number
    SERVICE = "gcd54379833fdb0_cbicn24vcdndg5uc_high.adb.oraclecloud.com"  # enter the oracle db service name
    ENGINE_PATH_WIN_AUTH = (
        DIALECT
        + "+"
        + SQL_DRIVER
        + "://"
        + USERNAME
        + ":"
        + PASSWORD
        + "@"
        + HOST
        + ":"
        + str(PORT)
        + "/?service_name="
        + SERVICE
    )

    engine = create_engine(ENGINE_PATH_WIN_AUTH)

    # test query
    import pandas as pd

    test_df = pd.read_sql_query("SELECT * FROM global_name", engine)


if __name__ == "__main__":
    # main()
    # test_alchemy()
    test2()
