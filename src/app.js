import express from "express";
import { connectDatabase } from "./config/database-connect.js";
import { rotasDosProjetos } from "./routes/index.js";
import cors from 'cors';

export const app = express();
app.use(cors());
rotasDosProjetos(app);

const connection = await connectDatabase();

connection.on("error", (erro) => {
    console.error("Houve um erro ao tentar a conexão com o banco de dados.", erro);
});

connection.once("open", () => {
    console.log("Conexão com o banco de dados bem sucedida.");    
});