import os
import sys
import subprocess
from pathlib import Path
import hvac
import hvac.api


class HashiCorpClient:
    def __init__(self):
        client = hvac.Client(
            url="http://127.0.0.1:8200",
            token="dev-only-token",
        )
        # Check if the Vault server is unsealed
        # if client.is_sealed():
        #     print("Vault is sealed. Please unseal it first.")
        #     sys.exit(1)

        # Check if the token is valid
        if not client.is_authenticated():
            print("Invalid token. Please provide a valid token.")
            sys.exit(1)

        seal_status = client.seal_status["sealed"]
        print(f"seal_status = {seal_status}")

        self.client = client

    def list_secrets(self):
        self.client.list("identity/entity/id")

    def save_secret(self):
        create_response = self.client.secrets.kv.v2.create_or_update_secret(
            path="my-secret-password",
            secret=dict(password="Hashi123"),
        )

        print(f"create_response: {create_response}")

    def read_secret(self):
        read_response = self.client.secrets.kv.read_secret_version(
            path="my-secret-password"
        )
        print(f"read_response: {read_response}")
        password = read_response["data"]["data"]["password"]
        return password


if __name__ == "__main__":
    hcc = HashiCorpClient()
    # hcc.save_secret()
    # hcc.list_secrets()
    password = hcc.read_secret()
