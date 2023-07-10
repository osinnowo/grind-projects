from fastapi import FastAPI, APIRouter
from router import users_router, course_router

app = FastAPI()
router = APIRouter()

# Include the users_router under the /users prefix
router.include_router(users_router, prefix="/users")

# Include the course_router under the /courses prefix
router.include_router(course_router, prefix="/courses")

# Include the router (containing users_router and course_router) under the /api/v1 prefix
app.include_router(router, prefix="/api/v1")
