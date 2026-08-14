// GANTI DENGAN URL DEPLOYMENT APPS SCRIPT ANDA
const SCRIPT_URL = "https://script.google.com/macros/s/AKfycbx0KD6MzXmcDG1-PstaJ86Db9fhi4yhuas5mqdWxKIu3aDME4ogog5mfbRohqfrN5OKqw/exec";

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

  } else {
    submitBtn.textContent = "Daftar";
    switchText.textContent = "Sudah punya akun?";
    switchLink.textContent = "Sign In";
  }
});

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
