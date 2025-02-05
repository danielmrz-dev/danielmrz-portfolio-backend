import mongoose from "mongoose";

export async function connectDatabase() {
    try {
        await mongoose.connect(process.env.DB_CONNECTION_STRING, {
            useNewUrlParser: true,
            useUnifiedTopology: true
        })
    } catch (error) {
        throw error;
    }
    return mongoose.connection;
    
}