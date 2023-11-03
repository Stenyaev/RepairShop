const form = document.getElementById('phone-form');
const producerInput = document.getElementById('producer');
const defectDescrInput = document.getElementById('defectDescr');
const dateInput = document.getElementById('date');
const timeInput = document.getElementById('time');
const addressInput = document.getElementById('address');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const producer = producerInput.value;
    const defectDescr = defectDescrInput.value;
    const date = dateInput.value;
    const time = timeInput.value;
    const address = addressInput.value;

    const data = {
        producer,
        defectDescr,
        date,
        time,
        address
    }

// Лютый костыль, не уверен, что достает нужное
    function getCookie(name) {
        let matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    const token = getCookie('jwtToken');

    try {
        const response = await fetch('http://localhost:8080/demo/appointments', {
            method: 'POST',
            body: JSON.stringify({data, token}),// Тут возможно надо иначе указывать данные, не знаю
            headers: {'Content-Type': 'application/json'}
        });

        if (response.ok) {
            window.location.href = "/demo/successful";

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