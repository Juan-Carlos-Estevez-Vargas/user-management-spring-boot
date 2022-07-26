// Call the dataTables jQuery plugin
// Esto se ejecuta al cargar la página.
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

// Realiza una petición y se conecta al backend para listar los usuarios presentes
// en el sistema.
async function cargarUsuarios(){
  const request = await fetch('/api/usuarios', {
    method: 'GET',
    headers: getHeaders()
  });
  const usuarios = await request.json();

  let listadoHtml = '';

  for (let usuario of usuarios) {
    let botonEliminarHtml = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let telefonoHtml = usuario.telefono == null ? '---' : usuario.telefono
    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefonoHtml+'</td><td>'+botonEliminarHtml+'</td></tr>';
    listadoHtml += usuarioHtml;
  }

  console.log(usuarios);
  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

function getHeaders() {
  return {
   'Accept': 'application/json',
   'Content-Type': 'application/json',
   'Authorization': localStorage.token
  }
}

async function eliminarUsuario(id) {
  if (!confirm('¿Desea eliminar este usuario?')) {
    return;
  }

  const request = await fetch('/api/usuario/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload();
}
