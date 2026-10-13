// Taller 1 - KotlinPet
// Desarrollo de Aplicativos Móviles (EE053)

// ---------- 1. Variables e interpolación ----------
println("--- 1. Ficha del paciente ---")

// nombre y sexo nunca cambian, por eso val
// edad, peso y vacunación sí se pueden actualizar, esos van con var
val nombre: String = "Firulais"
val sexo: Char = 'M'
var edad: Int = 3
var peso: Float = 15.5f
var vacunado: Boolean = true

// pasó un año y subió un poquito de peso
edad += 1
peso += 1.5f

println("Paciente: $nombre | Sexo: $sexo | Edad: $edad años | Peso: $peso kg | Vacunado: $vacunado")
println()

// ---------- 2. when y operadores lógicos ----------
println("--- 2. Categoría y prioridad ---")

// "edad" ya está declarada arriba, por eso aquí le puse edadPaciente
val edadPaciente: Int = 9
val esUrgencia: Boolean = false

val categoria = when (edadPaciente) {
    in 0..1 -> "Cachorro"
    in 2..7 -> "Adulto"
    in 8..Int.MAX_VALUE -> "Senior"
    else -> "Edad no válida" // aquí caen los negativos
}

println("Categoría: $categoria")

// basta con que sea urgencia o senior para que tenga prioridad
if (esUrgencia || categoria == "Senior") {
    println("Prioridad Alta")
} else {
    println("Atención Regular")
}
println()

// ---------- 3. Listas, for y rangos ----------
println("--- 3. Sala de espera ---")

val mascotasEnEspera = listOf("Luna", "Max", "Kira", "Toby")

// until no incluye el último número, por eso uso size y no size - 1
for (i in 0 until mascotasEnEspera.size) {
    println("Turno ${i + 1}: ${mascotasEnEspera[i]}")
}

println("\nLa clínica abre en:")
// downTo sí incluye el 1, cuenta de 5 a 1 sin saltarse nada
for (minuto in 5 downTo 1) {
    println("Faltan $minuto min...")
}
println("Clínica abierta\n")

// ---------- 4. Nulos ----------
println("--- 4. Manejo de nulos ---")

// no siempre se registra el contacto, así que puede ser null
var contactoEmergencia: String? = null

// con ?. no revienta si es null, solo devuelve null
val longitudContacto = contactoEmergencia?.length

// si es null usa el texto por defecto
val contactoFinal = contactoEmergencia ?: "Sin contacto registrado"

println("Contacto de emergencia: $contactoFinal")
println("Longitud del contacto: $longitudContacto")
println()

// ---------- 5. Lambdas ----------
println("--- 5. Precios con recargo nocturno ---")

// consulta, baño y desparasitación (en pesos)
val preciosBase = listOf(50000.0, 35000.0, 25000.0)

// recibe el precio y le suma el 10%
val aplicarRecargoNocturno = { precio: Double -> precio * 1.10 }

// uso format porque con doubles a veces salen decimales raros (55000.00000000001)
preciosBase.forEach {
    val conRecargo = aplicarRecargoNocturno(it)
    println("Precio original: ${"%.0f".format(it)} COP -> con recargo: ${"%.0f".format(conRecargo)} COP")
}
