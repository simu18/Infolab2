
if ! type javac >/dev/null 2>&1; then
    echo "Java not found. Installing..."
    sudo apt update
    sudo apt install default-jdk -y
else
    echo "Java is already installed."
fi

javac Hamming.java
