import express from "express";
import { ProjetoController } from "../controllers/projeto-controller.js";

export const projetosRoutes = express.Router();

projetosRoutes.get("/projetos", ProjetoController.listaProjetos);
projetosRoutes.get("/projetos/:id", ProjetoController.buscaProjetoPorId);
projetosRoutes.post("/projetos", ProjetoController.criaProjeto);
projetosRoutes.put("/projetos/:id", ProjetoController.editaProjeto);
projetosRoutes.delete("/projetos/:id", ProjetoController.excluiProjeto);