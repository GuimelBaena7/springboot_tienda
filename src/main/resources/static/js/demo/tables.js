// Call the dataTables jQuery plugin
$(document).ready(function() 
{
  cargetUserLog();
  $('#usuarios').DataTable();
});

async function cargetUserLog() {
    const response = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    
    const usuarios = await response.json();
    let listaHTML = '';

    for (let usuario of usuarios) 
    {
        let botonEliminar = '<a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>'

        let usuarioHtml = `
            <tr>
                <td>${usuario.nombre}</td>
                <td>${usuario.apellido}</td>
                <td>${usuario.email}</td>
                <td>${usuario.telefono}</td>
                <td>${botonEliminar}</td>
            </tr>`;
        listaHTML += usuarioHtml;
    }

    document.querySelector("#usuarios tbody").outerHTML = listaHTML;
}

async function eliminarUsuario(id) 
{
    const response = await fetch('usuarios/'+ id +'', {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
}
