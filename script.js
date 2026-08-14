// GANTI DENGAN URL DEPLOYMENT GOOGLE APPS SCRIPT ANDA
const SCRIPT_URL = "https://script.google.com/macros/s/AKfycbwe6Q1iKV2fhTGaF_Nn4fWw0i7OlZYydS5-8nRy0A8y/dev";

const loginForm = document.getElementById('loginForm');
const submitBtn = document.getElementById('submitBtn');
const messageBox = document.getElementById('messageBox');

loginForm.addEventListener('submit', async (e) => {
  e.preventDefault();

  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value.trim();

  if (!username || !password) return;

  submitBtn.disabled = true;
  submitBtn.textContent = "Memverifikasi...";
  messageBox.className = 'message';
  messageBox.style.display = 'none';

  const payload = {
    username: username,
    password: password
  };

  try {
    const response = await fetch(SCRIPT_URL, {
      method: "POST",
      body: JSON.stringify(payload)
    });

    const result = await response.json();

    if (result.status === "success") {
      messageBox.className = "message success";
      messageBox.textContent = result.message;
      loginForm.reset();

      // Opsional: Buka halaman lain setelah login berhasil
      // setTimeout(() => { window.location.href = "dashboard.html"; }, 1500);
    } else {
      messageBox.className = "message error";
      messageBox.textContent = result.message;
    }
  } catch (error) {
    messageBox.className = "message error";
    messageBox.textContent = "Gagal terhubung ke server.";
  } finally {
    submitBtn.disabled = false;
    submitBtn.textContent = "Masuk";
  }
});
