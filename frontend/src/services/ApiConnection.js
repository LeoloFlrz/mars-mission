import axios from 'axios'

const urlOperation = "http://localhost:8080/operations"
const urlResult = "http://localhost:8080/results"

class ApiConnection {
    async getAllResults() {
        try {
            let response = await axios.get(urlResult)
            return (response)
        } catch (error) {
            return (error.message)
        }
    }

    async getAllOperations() {
        try {
            let response = await axios.get(urlOperation)
            return (response)
        } catch (error) {
            return (error.message)
        }
    }

    async getResultById(id) {
        try {
            let response = await axios.get(`${urlResult}/${id}`)
            return (response)
        } catch (error) {
            return (error.message)
        }
    }

    async addResult(operationResult) {
        try{
            let response = await axios.post(`${urlResult}/postresult`, operationResult)
            return (response)
        }catch (error) {
            return (error.message)
        }
    }

    async addOperation(operation) {
        try {
            let response = await axios.post(urlOperation, operation)
            return (response)
        } catch (error) {
            return (error.message)
        }
    }
}