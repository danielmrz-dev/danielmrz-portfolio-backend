import express from "express";
import { connectDatabase } from "./config/database-connect.js";
import { rotasDosProjetos } from "./routes/index.js";

export const app = express();
rotasDosProjetos(app);

const connection = await connectDatabase();

connection.on("error", (erro) => {
    console.error("Houve um erro ao tentar a conexão com o banco de dados.", erro);
});

connection.once("open", () => {
    console.log("Conexão com o banco de dados bem sucedida.");    
});