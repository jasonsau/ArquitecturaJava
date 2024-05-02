async function cargaLibros() {
    const response = await fetch('/api/libros');
    const libros = await response.json();
    return libros;
}
async function insertarLibro() {
    const body = {
        isbn: document.querySelector('#isbn').value,
        titulo: document.querySelector('#titulo').value,
        categoria: document.querySelector('#categoria').value,
    }
    const respuesta = await fetch('/api/libros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

async function cargarCategorias() {
    const respuesta = await fetch('/api/libros/categorias');
    const categorias = await respuesta.json();
    return categorias;
}


window.onload = function () {
    console.log('Cargando libros...');

    const $form = document.querySelector('#formulario');
    const $verFormulario = document.querySelector('#verformulario');
    const $lista = document.querySelector('#lista');
    const $botonGuardar = document.querySelector('#botonguardar');
    const $tablaLibros = document.querySelector('#tablalibros');
    const $categoria = document.querySelector('#categoria');
    $form.style.display = 'none';
    $verFormulario.addEventListener('click', (e) => {
        $form.style.display = 'block';
        $lista.style.display = 'none';
        e.preventDefault();
    })

    $botonGuardar.addEventListener('click', (e) => {
        insertarLibro().then(() => {
            return cargaLibros()
        })
            .then((libros) =>{
                $tablaLibros.innerHTML = '';
                libros.map(l => `<tr><td>${l.isbn}</td><td>${l.titulo}</td>`)
                    .forEach(fila => $tablaLibros.innerHTML += fila);
                $form.style.display = 'none';
                $lista.style.display = 'block';
            });
        e.preventDefault();
    })


    cargaLibros().then(libros => {
        libros.map(l => `<tr><td>${l.isbn}</td><td>${l.titulo}</td>`)
            .forEach(fila => document.querySelector('#tablalibros').innerHTML += fila);
    });

    cargarCategorias().then(categorias => {
        categorias.map(c => `<option value="${c.id}">${c.nombre}</option>`)
            .forEach(fila => $categoria.innerHTML += fila);
    });
}