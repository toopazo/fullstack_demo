import os
import sys
import subprocess
from pathlib import Path
from dotenv import dotenv_values


class ExecJar:
    def __init__(self, env_path: Path):
        self.env_path = env_path
        assert (
            self.env_path.exists()
        ), f"Environment file {self.env_path} does not exist."
        self.config = dotenv_values(self.env_path)
        # print(self.config)

    def parse_command(self, jar_path: Path):
        # java -DR_HOME="/path/to/some-dir" -jar xxx.jar
        substr = "java"
        for key, value in self.config.items():
            substr = f'{substr} -D{key}="{value}"'
        substr = f"{substr} -jar {jar_path}"
        print(substr)

    def execute(self):
        # Get the path to the JAR file
        jar_path = os.path.join(os.path.dirname(__file__), "your_jar_file.jar")

        # Check if the JAR file exists
        if not os.path.exists(jar_path):
            print(f"Error: The JAR file {jar_path} does not exist.")
            sys.exit(1)

        # Execute the JAR file using Java
        try:
            subprocess.run(["java", "-jar", jar_path], check=True)
        except subprocess.CalledProcessError as e:
            print(f"Error executing the JAR file: {e}")
            sys.exit(1)


if __name__ == "__main__":
    envpath = Path(".env").resolve().absolute()
    # envpath = Path("../.env").resolve().absolute()
    execjar = ExecJar(envpath)
    # jarpath = Path("../build/libs/order-0.0.1-SNAPSHOT.jar")
    jarpath = Path("build/libs/order-0.0.1-SNAPSHOT.jar").absolute()
    assert jarpath.exists(), f"Jar file {jarpath} does not exist."
    execjar.parse_command(Path(jarpath))
