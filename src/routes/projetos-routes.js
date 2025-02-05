import express from "express";
import { ProjetoController } from "../controllers/projeto-controller.js";

export const projetosRoutes = express.Router();

projetosRoutes.get("/projetos", ProjetoController.listaProjetos);