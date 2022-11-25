window.addEventListener('load', function () {
    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del estudiante
    const formulario = document.querySelector('#update_estudiante_form');
    formulario.addEventListener('submit', function (event) {
        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarla para no cargarla como nuevo
        const formData = {
            id: document.querySelector('#estudiante_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT que modificará
        //al estudiante que enviaremos en formato JSON
        const url = '/estudiantes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
    //se encarga de llenar el formulario con los datos del estudiante
    //que se desea modificar
    function findBy(id) {
          const url = '/estudiantes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let estudiante = data;
              document.querySelector('#estudiante_id').value = estudiante.id;
              document.querySelector('#nombre').value = estudiante.nombre;
              document.querySelector('#apellido').value = estudiante.apellido;

              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_estudiante_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }