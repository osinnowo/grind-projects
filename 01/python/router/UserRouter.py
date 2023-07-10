from fastapi import APIRouter
from app import BaseResponse
from seed import database

router = APIRouter()


@router.get("/")
def get_users():
    return BaseResponse.ok(data=database)


@router.get("/{id}")
def get_user(id: int):
    return BaseResponse.ok(message=f"User By {id}")