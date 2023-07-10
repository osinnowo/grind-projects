from fastapi import APIRouter
from app import BaseResponse

router = APIRouter()


@router.get("/")
def get_courses():
    return BaseResponse.ok(message="All courses")


@router.get("/{id}")
def get_course(id: int):
    return BaseResponse.ok(message=f"Get Course By {id}")