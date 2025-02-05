import mongoose from "mongoose";

const projetoSchema = new mongoose.Schema({
    id: { type: mongoose.Schema.Types.ObjectId },
    name: { type: String, required: true },
    images: {
        small: { type: String, required: true },
        large: { type: String, required: true },
    },
    technologies: [{ type: String, required: true }],
    repository: { type: String, required: true },
    liveSite: { type: String, required: true },
    
}, { versionKey: false });

export const projeto = mongoose.model("projetos", projetoSchema);