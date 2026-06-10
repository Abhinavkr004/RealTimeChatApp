import axios from 'axios';
export const baseURL= 'https://chatapp-backend-1-f1wn.onrender.com';
export const httpClient = axios.create({
    baseeURL: baseURL,
});