const form = document.getElementById('authorization-form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');

form.addEventListener('submit', async (event) => {
    event.preventDefault();
    const username = usernameInput.value;
    const password = passwordInput.value;

    const data = {
        username,
        password
    }

    try {
        const response = await fetch('http://localhost:8080/demo/auth', {
            method: 'POST',
            body: JSON.stringify({username, password}),
            headers: {'Content-Type': 'application/json'}
        });

        if (response.ok) {
            response.json().then((data) => document.cookie = "jwtToken=" + data.token + ";");
                const cookie = document.cookie;
                let jwtToken = null;
                for (const cook of cookie.split(";")) {
                    const [name, value] = cook.split("=");
                    if (name === "jwtToken") {
                    jwtToken = value;
                    break;
                    }
                }
            const token = jwtToken;
            console.log(jwtToken);

            window.location.href = "/demo/mainpage";
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