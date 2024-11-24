/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],

    theme: {
      extend: {
        transitionDuration: {
          '300': '300ms',
        },
        transitionTimingFunction: {
          'ease-out': 'cubic-bezier(0.25, 0.1, 0.25, 1)',
        },
      },
  },
  plugins: [],
}