// GANTI DENGAN URL DEPLOYMENT APPS SCRIPT ANDA
const SCRIPT_URL = "URL_WEB_APP_GOOGLE_SCRIPT_ANDA";

let isLoginMode = true;

const formTitle = document.getElementById('formTitle');
const formSubtitle = document.getElementById('formSubtitle');
const submitBtn = document.getElementById('submitBtn');
const switchLink = document.getElementById('switchLink');
const switchText = document.getElementById('switchText');
const messageBox = document.getElementById('messageBox');
const authForm = document.getElementById('authForm');

// Toggle Mode Login / Register
switchLink.addEventListener('click', () => {
  isLoginMode = !isLoginMode;
  messageBox.className = 'message';
  messageBox.style.display = 'none';

  if (isLoginMode) {
    formTitle.textContent = "Sign In";
    formSubtitle.textContent = "Masukkan kredensial Anda untuk melanjutkan";
    submitBtn.textContent = "Masuk";
    switchText.textContent = "Belum punya akun?";
    switchLink.textContent = "Daftar Akun";
  } else {
    formTitle.textContent = "Register";
    formSubtitle.textContent = "Buat akun baru Anda";
    submitBtn.textContent = "Daftar";
    switchText.textContent = "Sudah punya akun?";
    switchLink.textContent = "Sign In";
  }
});

// Kirim Data ke Google Sheet
authForm.addEventListener('submit', async (e) => {
  e.preventDefault();

  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value.trim();

  if (!username || !password) return;

  submitBtn.disabled = true;
  submitBtn.textContent = "Memproses...";
  messageBox.className = 'message';
  messageBox.style.display = 'none';

  const payload = {
    action: isLoginMode ? "login" : "register",
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
      if (isLoginMode) {
        authForm.reset();
        // Contoh aksi redirect jika login berhasil:
        // setTimeout(() => { window.location.href = "dashboard.html"; }, 1500);
      } else {
        setTimeout(() => switchLink.click(), 1200);
      }
    } else {
      messageBox.className = "message error";
      messageBox.textContent = result.message;
    }
  } catch (error) {
    messageBox.className = "message error";
    messageBox.textContent = "Terjadi kesalahan koneksi ke server.";
  } finally {
    submitBtn.disabled = false;
    submitBtn.textContent = isLoginMode ? "Masuk" : "Daftar";
  }
});
