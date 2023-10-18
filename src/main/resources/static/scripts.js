function registrarPaciente() {
  const form = document.getElementById("registroPacienteForm");
  if (form) {
    form.addEventListener("submit", function (event) {
      event.preventDefault(); // Evita que el formulario se envíe automáticamente

      // Obtén los valores de los campos del formulario
      let nombre = document.getElementById("nombre").value;
      let apellido = document.getElementById("apellido").value;
      let dni = document.getElementById("dni").value;
      let fechaIngreso = document.getElementById("fechaIngreso").value;
      let calle = document.getElementById("calle").value;
      let numero = document.getElementById("numero").value;
      let localidad = document.getElementById("localidad").value;
      let provincia = document.getElementById("provincia").value;

      // Crea un objeto con los datos a enviar
      let pacienteData = {
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        fechaIngreso: fechaIngreso,
        domicilio: {
          calle: calle,
          numero: numero,
          localidad: localidad,
          provincia: provincia,
        }
      };

      // Realiza la solicitud POST al servidor
      fetch("http://localhost:8080/pacientes/registrar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(pacienteData),
      })
        .then((response) => response.json())
        .then((data) => {
          // Maneja la respuesta del servidor aquí
          console.log(data);
          alert("Paciente registrado con éxito.");
          // Puedes redirigir a otra página o hacer otras acciones después de registrar al paciente
        })
        .catch((error) => {
          console.error("Error:", error);
          alert("Hubo un error al registrar al paciente.");
        });
    });
  }
}

function registrarOdontologo() {
  const form = document.getElementById("registroOdontologoForm");
  if (form) {
    form.addEventListener("submit", function (event) {
      event.preventDefault(); // Evita que el formulario se envíe automáticamente

      // Obtén los valores de los campos del formulario
      let nombre = document.getElementById("nombre").value;
      let apellido = document.getElementById("apellido").value;
      let matricula = document.getElementById("matricula").value;

      // Crea un objeto con los datos a enviar
      let odontologoData = {
        matricula: matricula,
        nombre: nombre,
        apellido: apellido,
      };

      // Realiza la solicitud POST al servidor
      fetch("http://localhost:8080/odontologos/registrar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(odontologoData),
      })
        .then((response) => response.json())
        .then((data) => {
          // Maneja la respuesta del servidor aquí
          console.log(data);
          alert("Odontólogo registrado con éxito.");
          // Puedes redirigir a otra página o hacer otras acciones después de registrar al odontólogo
        })
        .catch((error) => {
          console.error("Error:", error);
          alert("Hubo un error al registrar al odontólogo.");
        });
    });
  }
}


function mostrarPaciente() {
  // Realiza la solicitud GET al servidor para obtener la lista de pacientes
  fetch("http://localhost:8080/pacientes", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      // Maneja la respuesta del servidor aquí
      console.log(data);

      // Supongamos que tienes un elemento HTML con un ID "listaPacientes" donde deseas mostrar la lista de pacientes
      const listaPacientes = document.getElementById("listaPacientes");

      // Limpia cualquier contenido anterior en la lista
      listaPacientes.innerHTML = "";

      // Itera a través de los pacientes y crea elementos HTML para mostrarlos
      data.forEach((paciente) => {
        const pacienteElement = document.createElement("div");
        pacienteElement.innerHTML = `
          <h3>${paciente.nombre} ${paciente.apellido}</h3>
          <p>DNI: ${paciente.dni}</p>
          <p>Fecha de Ingreso: ${paciente.fechaIngreso}</p>
          <p>Domicilio: ${paciente.domicilio.calle} ${paciente.domicilio.numero}, ${paciente.domicilio.localidad}, ${paciente.domicilio.provincia}</p>
        `;

        listaPacientes.appendChild(pacienteElement);
      });
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Hubo un error al obtener la lista de pacientes.");
    });
}

// Llama a la función para mostrar pacientes al cargar la página
mostrarPaciente();


// Llama a las funciones para registrar pacientes y odontólogos
registrarPaciente();
registrarOdontologo();