import mongoose from "mongoose";

const projetoSchema = new mongoose.Schema({
    id: { type: mongoose.Schema.Types.ObjectId },
    nome: { type: String, required: true },
    repo: { type: String, required: true },
    liveSite: { type: String, required: true },
    preview: { type: String, required: true },
}, { versionKey: false });

export const projeto = mongoose.model("projetos", projetoSchema);