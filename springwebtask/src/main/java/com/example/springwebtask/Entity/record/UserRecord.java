package com.example.springwebtask.Entity.record;

import lombok.Data;

import java.sql.Timestamp;

public record UserRecord(int id, String login_id, String password, String name, int role, Timestamp created_at, Timestamp updated_at) {}