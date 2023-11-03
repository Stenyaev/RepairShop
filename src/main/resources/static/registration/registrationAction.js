const form = document.getElementById('registration-form');
const usernameInput = document.getElementById('username');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const username = usernameInput.value;
    const email = emailInput.value;
    const password = passwordInput.value;

    try {
        const response = await fetch('http://localhost:8080/demo/users', {
            method: 'POST',
            body: JSON.stringify({username, email, password}),
            headers: {'Content-Type': 'application/json'}
        });
        // сделать через гет
        if (response.ok) {
            window.location.href = "/demo/authorization";
        } else {
            const error = await response.json();
            const errorMessage = error.message || 'Произошла ошибка';
            showErrorMessage(errorMessage);
        }
    } catch (error) {
        showErrorMessage('Произошла ошибка');
    }
});

function showErrorMessage(message) {
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-message');
    errorElement.textContent = message;
    form.appendChild(errorElement);
}