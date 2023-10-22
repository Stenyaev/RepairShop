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

    try {
        const response = await fetch('/appointment', {
            method: 'POST',
            body: JSON.stringify({producer, defectDescr, date, time, address}),
            headers: {'Content-Type': 'application/json'}
        });

        if (response.ok) {
            window.location.href = "/mainpage";
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