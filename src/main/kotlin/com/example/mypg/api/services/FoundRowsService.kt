package com.example.mypg.api.services

import com.example.mypg.api.`interface`.response.FoundRows
import com.example.mypg.api.repositorys.FoundRowsRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class FoundRowsService(
        private val repository: FoundRowsRepository
) {
    fun getFoundRows(): ResponseEntity<FoundRows> {
        return repository.getFoundRows()
    }
}