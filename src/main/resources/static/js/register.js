function handleRegistration(event) {
    event.preventDefault(); // Evita que el enlace navegue a otra página

    const firstName = document.getElementById('exampleFirstName').value;
    const lastName = document.getElementById('exampleLastName').value;
    const email = document.getElementById('exampleInputEmail').value;
    const password = document.getElementById('exampleInputPassword').value;

    // Realiza la solicitud AJAX al endpoint de registro
    fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ firstName, lastName, email, password }),
    })
    .then(response => {
        if (response.ok) {
            window.location.href = 'login.html'; // Redirige en caso de éxito
        } else {
            alert('Registration failed. Please try again.');
        }
    })
    .catch(error => console.error('Error:', error));
}

// Attach event listener to the register form
document.getElementById('registerForm').addEventListener('submit', handleRegistration);
