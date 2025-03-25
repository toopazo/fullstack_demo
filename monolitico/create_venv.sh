
#!/bin/bash

# apt install python3.10-venv -y
# apt install python3.10-dev -y

python3.10 -m venv venv
source venv/bin/activate

python -m pip install --upgrade pip
python -m pip install --upgrade pylint
python -m pip install --upgrade black
python -m pip install --upgrade flake8
python -m pip install --upgrade isort

python -m pip install -r requirements.txt