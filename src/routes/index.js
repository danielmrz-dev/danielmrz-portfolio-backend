import express from 'express';
import { projetosRoutes } from './projetos-routes.js';

export const rotasDosProjetos = (app) => {
    app.route("/").get((req, res) => res.status(200).send("Projetos Front-end!"))
    app.use(express.json(), projetosRoutes);
}