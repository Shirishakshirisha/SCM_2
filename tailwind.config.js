/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",  // Thymeleaf templates
    "./src/main/resources/static/**/*.js",       // JS files in static
    "./src/main/resources/static/**/*.css",      // CSS files in static
  ],
  theme: {
    extend: {},
  },
  plugins: [],
  darkMode: "selector", // Enable dark mode via a CSS class
}
