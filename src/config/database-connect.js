import mongoose from "mongoose";

export async function connectDatabase() {
    try {
        await mongoose.connect(process.env.DB_CONNECTION_STRING);
        console.log("Conectado ao Mongo com sucesso! 🔥");
    } catch (error) {
        console.log("Erro ao conectar ao MongoDB... ☹️");
        throw error;
    }
    return mongoose.connection;
    
}