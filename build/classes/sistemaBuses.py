# Definir arreglos para almacenar información
paradas = [""] * 5
horarios = [["", ""] for _ in range(5)]
rutas = [[""] * 5 for _ in range(3)]

# Función para registrar una parada
def registrar_parada(indice, nombre, salida, llegada):
    if 0 <= indice < len(paradas):
        paradas[indice] = nombre
        horarios[indice][0] = salida
        horarios[indice][1] = llegada

# Función para registrar una ruta
def registrar_ruta(indice, ruta):
    if 0 <= indice < len(rutas):
        for i in range(len(ruta)):
            rutas[indice][i] = ruta[i]

# Procedimiento para mostrar paradas
def mostrar_paradas():
    print("\nParadas y Horarios:")
    for i in range(len(paradas)):
        if paradas[i]:
            print(f"{i + 1}. {paradas[i]} - Salida: {horarios[i][0]}, Llegada: {horarios[i][1]}")

# Procedimiento para mostrar rutas
def mostrar_rutas():
    print("\nRutas de Autobuses:")
    for i in range(len(rutas)):
        if rutas[i][0]:
            print(f"Ruta {i + 1}: ", end="")
            for j in range(len(rutas[i])):
                if rutas[i][j]:
                    print(f"{rutas[i][j]} -> ", end="")
            print("Fin")

# Menú principal
def menu():
    while True:
        print("\nMenú:")
        print("1. Registrar Parada")
        print("2. Registrar Ruta")
        print("3. Mostrar Paradas")
        print("4. Mostrar Rutas")
        print("5. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            indice = int(input("Ingrese el índice de la parada (0-4): "))
            nombre = input("Nombre de la parada: ")
            salida = input("Hora de salida: ")
            llegada = input("Hora de llegada: ")
            registrar_parada(indice, nombre, salida, llegada)

        elif opcion == "2":
            indice = int(input("Ingrese el índice de la ruta (0-2): "))
            ruta = ["" for _ in range(5)]
            for i in range(5):
                parada = input(f"Ingrese la parada {i + 1} (o presione Enter para terminar): ")
                if parada == "":
                    break
                ruta[i] = parada
            registrar_ruta(indice, ruta)

        elif opcion == "3":
            mostrar_paradas()

        elif opcion == "4":
            mostrar_rutas()

        elif opcion == "5":
            print("Saliendo...")
            break

        else:
            print("Opción inválida.")

# Ejecutar menú
if __name__ == "__main__":
    menu()
