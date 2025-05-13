import sys
import boto3
from botocore.exceptions import ClientError


def test_secrets(path: str):
    # print(path)
    try:
        # Create a Secrets Manager client
        secrets_manager_client = boto3.client("secretsmanager")

        # Get the secret value
        response = secrets_manager_client.get_secret_value(SecretId=path)
        # secret_string = response["SecretString"]  # For text secrets
        secret = (
            response["SecretString"]
            if response["SecretString"]
            else response["SecretBinary"]
        )
        # Decode the secret if it's in binary format
        if "SecretBinary" in response:
            secret = response["SecretBinary"].decode(
                "utf-8"
            )  # or decode as appropriate

        print(f"Retrieved secret: {secret}")

    except ClientError as e:
        # Handle any exceptions
        print(f"Error: {e}")


if __name__ == "__main__":
    test_secrets(sys.argv[1])
