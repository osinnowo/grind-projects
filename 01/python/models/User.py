from pydantic import BaseModel
from typing import Optional, List
from uuid import UUID, uuid4
from enum import Enum


class Role(str, Enum):
    """Enumeration representing user roles."""

    admin = "admin"
    user = "user"
    student = "student"


class Gender(str, Enum):
    """Enumeration representing user genders."""

    male = "male"
    female = "female"


class User(BaseModel):
    """
    Represents a user.

    Attributes:
        id (Optional[UUID]): The unique identifier of the user. Defaults to a newly generated UUID.
        first_name (str): The first name of the user.
        last_name (str): The last name of the user.
        middle_name (Optional[str]): The middle name of the user. Defaults to None.
        gender (Gender): The gender of the user.
        roles (List[Role]): The roles assigned to the user.
    """

    id: Optional[UUID] = uuid4()
    first_name: str
    last_name: str
    middle_name: Optional[str]
    gender: Gender
    roles: List[Role]