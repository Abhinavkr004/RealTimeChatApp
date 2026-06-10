import axios from 'axios';
export const baseURL= 'https://chatapp-backend-2-n84o.onrender.com';
export const httpClient = axios.create({
    baseURL: baseURL,
});