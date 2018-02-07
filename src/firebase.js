import { initializeApp } from 'firebase';

// Initialize Firebase
const app = initializeApp({
    apiKey: "AIzaSyBDe4jwk189QzSkyfurfEuML2LfDmBdJiQ",
    authDomain: "vuefire-crud.firebaseapp.com",
    databaseURL: "https://vuefire-crud.firebaseio.com",
    projectId: "vuefire-crud",
    storageBucket: "",
    messagingSenderId: "326086031354"
});

export const db = app.database();
export const namesRef = db.ref('names');