// JavaScript for handling login and registration
// Function to handle login
function handleLogin(event) {
    event.preventDefault(); // Prevent the default form submission
    const email = document.getElementById('exampleInputEmail').value;
    const password = document.getElementById('exampleInputPassword').value;
    // Perform AJAX request to login endpoint
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
    })
    .then(response => {
        if (response.ok) {
            window.location.href = 'index.html'; // Redirect on success
        } else {
            alert('Login failed. Please check your credentials.');
        }
    })
}